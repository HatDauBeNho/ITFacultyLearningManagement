package Haui.ITFacultyLearningManagement.service;

import Haui.ITFacultyLearningManagement.custom.major.response.MajorResponse;
import Haui.ITFacultyLearningManagement.entities.Major;

import java.util.List;
import java.util.Optional;

public interface MajorService extends  Generate<Major>{
    Optional<Major> findByName(String name);
    List<MajorResponse> findAllForView();
    long countMajor();
}
