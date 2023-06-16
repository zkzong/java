package org.example.sb.dto;

import lombok.Data;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: zong
 * @Date: 2022/3/3
 */
@Data
public class UserReq {
    @Valid
    private List<UserDTO> dtoList;
}
