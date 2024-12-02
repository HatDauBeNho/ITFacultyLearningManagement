package Haui.ITFacultyLearningManagement.service.impl;

import Haui.ITFacultyLearningManagement.custom.result.response.ResultResponse;
import Haui.ITFacultyLearningManagement.repository.ResultRepository;
import Haui.ITFacultyLearningManagement.repository.StudentRepository;
import Haui.ITFacultyLearningManagement.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ResultServiceImpl implements ResultService {
    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public ResultResponse getResult(int studentId) {
        return new ResultResponse(studentRepository.getGpa(studentId),resultRepository.getResult(studentId));
    }
}
