package uz.demo.app_data_api.service.imple;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import uz.demo.app_data_api.entity.AttachmentContent;
import uz.demo.app_data_api.entity.Attachment;
import uz.demo.app_data_api.repository.AttachmentContentRepository;
import uz.demo.app_data_api.repository.AttachmentRepository;
import uz.demo.app_data_api.service.AttachmentService;

import java.io.IOException;
import java.util.Optional;

@Service
public class AttachmentServiceImpl implements AttachmentService {
    @Autowired
    private AttachmentRepository attachmentRepository;
    @Autowired
    private AttachmentContentRepository attachmentContentRepository;

    @Override
    public ResponseEntity<Attachment> addAttachment(MultipartFile file) {
        if (!file.isEmpty()) {

            String name = file.getOriginalFilename();
            Long size = file.getSize();
            String contentType = file.getContentType();

            Attachment attachment = new Attachment();
            attachment.setName(name);
            attachment.setSize(size);
            attachment.setContentType(contentType);
            Attachment savedAttachment = attachmentRepository.save(attachment);

            AttachmentContent attachmentContent = new AttachmentContent();
            try {
                attachmentContent.setBytes(file.getBytes());
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
            }
            attachmentContent.setAttachment(savedAttachment);
            attachmentContentRepository.save(attachmentContent);

            return ResponseEntity.status(HttpStatus.CREATED).body(savedAttachment);
        }
        return ResponseEntity.badRequest().body(null);
    }

    @Override
    public ResponseEntity<?> getAttachment(Integer id, HttpServletResponse response) {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isPresent()) {
            Attachment attachment = optionalAttachment.get();
            Optional<AttachmentContent> optionalAttachmentContent = attachmentContentRepository.findByAttachmentId(id);
            if (optionalAttachmentContent.isPresent()) {
                AttachmentContent attachmentContent = optionalAttachmentContent.get();

                response.setHeader("Content-Disposition", "attachment; filename=\"" + attachment.getName() + "\"");
                response.setContentType(attachment.getContentType());
                try {
                    FileCopyUtils.copy(attachmentContent.getBytes(), response.getOutputStream());
                    return ResponseEntity.status(200).body("Download");
                } catch (Exception e) {
                    return ResponseEntity.status(409).body("Error");
                }
            }
        }
        return ResponseEntity.status(409).body("Error");
    }

    @Override
    public ResponseEntity<?> deleteAttachment(Integer id) {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isPresent()) {
            Optional<AttachmentContent> optionalAttachmentContent = attachmentContentRepository.findByAttachmentId(id);
            optionalAttachmentContent.ifPresent(attachmentContent -> attachmentContentRepository.deleteById(attachmentContent.getId()));
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<?> updateAttachment(Integer id, MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else{
            Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
            if (optionalAttachment.isPresent()) {
                Attachment attachment = optionalAttachment.get();
                attachment.setName(file.getOriginalFilename());
                attachment.setContentType(file.getContentType());
                attachment.setSize(file.getSize());
                Attachment savedAttachment = attachmentRepository.save(attachment);
                Optional<AttachmentContent> optionalAttachmentContent = attachmentContentRepository.findByAttachmentId(id);
                if (optionalAttachmentContent.isPresent()) {
                    AttachmentContent attachmentContent = optionalAttachmentContent.get();
                    try {
                        attachmentContent.setBytes(file.getBytes());
                        attachmentContent.setAttachment(savedAttachment);
                        return ResponseEntity.status(HttpStatus.OK).body(savedAttachment);
                    } catch (IOException e) {
                        return ResponseEntity.status(HttpStatus.CONFLICT).build();
                    }
                }
            }
            else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.badRequest().build();
    }
}
