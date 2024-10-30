package Haui.ITFacultyLearningManagement.service.impl;

import Haui.ITFacultyLearningManagement.custom.major.response.MajorResponse;
import Haui.ITFacultyLearningManagement.entities.Major;
import Haui.ITFacultyLearningManagement.repository.InfoRepository;
import Haui.ITFacultyLearningManagement.repository.MajorRepository;
import Haui.ITFacultyLearningManagement.repository.TeacherRepository;
import Haui.ITFacultyLearningManagement.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MajorServiceImpl implements MajorService {
    @Autowired
    private MajorRepository majorRepository;

    @Autowired
    private InfoRepository infoRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Major> findAll() {
        return majorRepository.findAll();
    }

    @Override
    public Optional<Major> findById(Integer id) {
        return majorRepository.findById(id);
    }

    @Override
    public Major save(Major major) {
        return majorRepository.save(major);
    }

    @Override
    public void deleteById(Integer id) {
        majorRepository.deleteById(id);
    }


    @Override
    public Optional<Major> findByName(String name) {
        return majorRepository.findByName(name);
    }

    @Override
    public List<MajorResponse> findAllForView() {
        List<MajorResponse> list=new ArrayList<>();
//        for(Major item:majorRepository.findAll())
//        {
//            MajorResponse majorResponse=new MajorResponse(
//                    item.getMajorId(),
//                    item.getMajorName(),
//                    departmentRepository.findById(item.getDepartmentId()).get().getDepartmentName(),
//                    inforRepository.findById(teacherRepository.findById(item.getTeacherId()).get().getInforId()).get().getFullName(),
//                    item.getCreateAt(),
//                    item.getUpdatedAt()
//            );
//            list.add(majorResponse);
//        }
        return list;
    }

    @Override
    public long countMajor() {
        return majorRepository.count();
    }
}
