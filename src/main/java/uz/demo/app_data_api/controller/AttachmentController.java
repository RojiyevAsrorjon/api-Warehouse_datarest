package uz.demo.app_data_api.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.demo.app_data_api.entity.Attachment;
import uz.demo.app_data_api.service.AttachmentService;

@RestController
@RequestMapping("/api/attachment")
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;

    @GetMapping("/{id}")
    public HttpEntity<?> getAttachment(@PathVariable Integer id, HttpServletResponse response) {
        return attachmentService.getAttachment(id, response);

    }

    @PostMapping
    public HttpEntity<?> createAttachment(MultipartFile file) {
        return attachmentService.addAttachment(file);
    }

}

