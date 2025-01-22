package ru.practicum.service;

import jakarta.validation.Valid;
import ru.practicum.dto.comment.CommentDto;
import ru.practicum.dto.comment.NewCommentDto;
import ru.practicum.model.Comment;

import java.util.List;

public interface CommentService {
    CommentDto createComment(Long userId, Long eventId, NewCommentDto newCommentDto);

    CommentDto updateByUser(Long userId, Long commentId, @Valid NewCommentDto newCommentDto);

    List<CommentDto> getCommentsByUser(Long userId);

    Comment getCommentByUserIdAndCommentId(Long userId, Long commentId);

    List<Comment> getCommentsInEvent(Long eventId, Integer from, Integer size);

    void deleteComment(Long userId, Long commentId);

    void deleteCommentByAdmin(Long commentId);

    List<Comment> getCommentsByText(String text, Integer from, Integer size);
}
