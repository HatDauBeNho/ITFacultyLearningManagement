package Haui.ITFacultyLearningManagement.service.impl;

import Haui.ITFacultyLearningManagement.entities.Teacher;
import Haui.ITFacultyLearningManagement.repository.AccountRepository;
import Haui.ITFacultyLearningManagement.repository.TeacherRepository;
import Haui.ITFacultyLearningManagement.service.AccountService;
import Haui.ITFacultyLearningManagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountService accountService;

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Optional<Teacher> findById(Integer id) {
        return teacherRepository.findById(id);
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteById(Integer id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public Optional<Teacher> findByName(String name) {
        return teacherRepository.findByName(name);
    }

    @Override
    public Optional<Teacher> findByAccountId(int accountId) {
        return teacherRepository.findByAccountId(accountId);
    }
}
