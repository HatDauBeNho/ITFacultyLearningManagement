package Haui.ITFacultyLearningManagement.service;

import Haui.ITFacultyLearningManagement.entities.Lecture;

import java.util.Optional;

public interface LectureService extends Generate<Lecture> {
    Optional<Lecture> findByName(String name);

    Optional<Lecture> findByAccountId(int accountId);

}
