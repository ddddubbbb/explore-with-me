package ru.practicum.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.practicum.event.dto.EventShortDto;
import ru.practicum.user.dto.UserShortDto;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class CommentResponseDto {
    private Long id;
    private EventShortDto event;
    private UserShortDto author;
    private String text;
    private String state;
    private String createdOn;
    private String updatedOn;
    private String publishedOn;
}