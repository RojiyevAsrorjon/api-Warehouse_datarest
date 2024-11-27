package uz.demo.app_data_api.service;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.demo.app_data_api.entity.Attachment;

import java.net.http.HttpResponse;
import java.util.Map;

@Service
public interface AttachmentService {

    ResponseEntity<Attachment> addAttachment(MultipartFile file);

    ResponseEntity<?> getAttachment(Integer id, HttpServletResponse response);

    ResponseEntity<?> deleteAttachment(Integer id);
    ResponseEntity<?> updateAttachment(Integer id, MultipartFile file);
}
