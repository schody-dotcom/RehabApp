package pwr.edu.rehabapp.utilities.mapper;

import pwr.edu.rehabapp.dto.ExerciseSetDto;
import pwr.edu.rehabapp.entity.ExerciseSet;

import java.util.List;
import java.util.stream.Collectors;

public class ExerciseSetMapper {

    public static ExerciseSetDto mapExerciseSetToExerciseSetDto(ExerciseSet exerciseSet){
        ExerciseSetDto dto = new ExerciseSetDto();
        dto.setNumber(exerciseSet.getNumber());
        dto.setName(exerciseSet.getName());
        dto.setDifficulty(exerciseSet.getDifficulty());

        return dto;
    }

    public static List<ExerciseSetDto> mapExerciseSetListToExerciseSetDtoList(List<ExerciseSet> exerciseSets){
        return exerciseSets.stream()
                .map(ExerciseSetMapper::mapExerciseSetToExerciseSetDto)
                .collect(Collectors.toList());
    }

    public static ExerciseSet mapExerciseSetDtoToExerciseSet(ExerciseSetDto dto){
        ExerciseSet exerciseSet = new ExerciseSet();
        exerciseSet.setNumber(dto.getNumber());
        exerciseSet.setName(dto.getName());
        exerciseSet.setDifficulty(dto.getDifficulty());

        return exerciseSet;
    }





}
