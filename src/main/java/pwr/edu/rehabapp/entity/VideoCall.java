package pwr.edu.rehabapp.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class VideoCall extends Contact{


    @Id
    private Long id;

    public VideoCall(LocalDateTime date, int time, Patient patient, Doctor doctor) {
        super(date, time, patient, doctor);
    }



    private String recordingName() {
        return null;
    }



}
