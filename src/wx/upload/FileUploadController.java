package wx.upload;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class FileUploadController {

    @RequestMapping("/fileUpload")
    public String fileUpload(String name,
                             @RequestParam("uploadFile")List<MultipartFile> uploadFile) throws IOException {
        System.out.println("执行了");
        if(!uploadFile.isEmpty()){
            for(MultipartFile file :uploadFile){
                String fileName=file.getOriginalFilename();//获取文件真实名称
                String newFileName=name+"_"+UUID.randomUUID()+"_"+fileName;
                System.out.println(newFileName);
                File filepath=new File("D:\\upload\\");
                file.transferTo(new File(filepath,newFileName));
            }
        }
        return "index.jsp";
    }
}
