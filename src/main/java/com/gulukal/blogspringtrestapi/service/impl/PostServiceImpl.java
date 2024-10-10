package com.gulukal.blogspringtrestapi.service.impl;

import com.gulukal.blogspringtrestapi.dto.PostDto;
import com.gulukal.blogspringtrestapi.dto.PostResponse;
import com.gulukal.blogspringtrestapi.entity.Post;
import com.gulukal.blogspringtrestapi.exception.ResourceNotFoundException;
import com.gulukal.blogspringtrestapi.repository.PostRepository;
import com.gulukal.blogspringtrestapi.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Gulten Ulukal
 */

@Service
public class PostServiceImpl implements PostService {

    /**
     * Construction dependency injection
     */
    private final PostRepository postRepository;
    private final ModelMapper mapper;

    public PostServiceImpl(PostRepository postRepository, ModelMapper mapper) {
        this.postRepository = postRepository;
        this.mapper = mapper;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        //convert dto to entity
        Post post = mapToEntity(postDto);

        Post newPost = postRepository.save(post);

        //convert entity to dto
        PostDto postResponse = mapToDto(newPost);

        return postResponse;
    }

    @Override
    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy,String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        //create pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Post> posts= postRepository.findAll(pageable);

        //get content for page object
        List<Post> listOfPosts = posts.getContent();

        List<PostDto> content =  listOfPosts.stream().map(post->mapToDto(post)).collect(Collectors.toList());

        //create postResponse object to return
        PostResponse postResponse = new PostResponse();

        postResponse.setContent(content);
        postResponse.setPageNo(posts.getNumber());
        postResponse.setPageSize(posts.getSize());
        postResponse.setTotalElements(posts.getTotalElements());
        postResponse.setTotalPages(posts.getTotalPages());
        postResponse.setLast(posts.isLast());

        return postResponse;
    }

    @Override
    public PostDto getPostById(long id) {
        //get post by id from the database
        Post post = getPostByIdFromDatabase(id);

        return mapToDto(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        //get post by id from the database
        Post post = getPostByIdFromDatabase(id);

        //update post
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        //return and save updated post in the database
        Post updatePost = postRepository.save(post);
        return mapToDto(updatePost);
    }

    @Override
    public void deletePostById(long id) {
        //get post by id from the database
        Post post = getPostByIdFromDatabase(id);

        //delete post from database
        postRepository.deleteById(id);


    }

    //get post by id from the database
    private Post getPostByIdFromDatabase(long id) {

        return postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
    }


    //convert entity to dto
    private PostDto mapToDto(Post post) {

        //map with modelMapper lib.
        PostDto postDto = mapper.map(post, PostDto.class);

        return postDto;

        //map with hardcode
//        return PostDto.builder()
//                .id(post.getId())
//                .title(post.getTitle())
//                .description(post.getDescription())
//                .content(post.getContent())
//                .build();
    }

    //convert dto to entity
    private Post mapToEntity(PostDto postDto) {

        //map with modelMapper lib.
        Post post = mapper.map(postDto, Post.class);

        return post;

        //map with hardcode
//        return Post.builder()
//                .id(postDto.getId())
//                .title(postDto.getTitle())
//                .description(postDto.getDescription())
//                .content(postDto.getContent())
//                .build();
    }
}
