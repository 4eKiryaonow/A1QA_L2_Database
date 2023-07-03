package utils.api;

import model.api.dto.Post;

import java.util.Comparator;

import java.util.List;
import java.util.stream.Collectors;

public class RestPostUtil {
    public static List<Post> getSortedPostsByUserId(List<Post> list) {
        return list
                .stream()
                .sorted(Comparator.comparing(post -> Integer.parseInt(post.getId())))
                .collect(Collectors.toList());
    }
}