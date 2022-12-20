package pwr.edu.rehabapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//PU: Przesyłanie feedbacku - infromacje do wiadomosci zwrotnej. Zawiera liste wykonanych ćwiczeń w danym zestawie.
public class ExerciseSetPerformedDto {

    private long exerciseSetNumber;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;
    private List<ExercisePerformedDto> exercisesPerformed; //lista wykonanych ćwiczeń
    private int assessment; //ogólna ocena ćwiczenia wydana przez pacjenta
    private String message; //wiadomość zwrotna


}
