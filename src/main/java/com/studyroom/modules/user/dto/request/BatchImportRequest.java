package com.studyroom.modules.user.dto.request;


import lombok.Data;
import java.util.List;
@Data
public class BatchImportRequest {

    private List<UserCreateRequest> users;
}
