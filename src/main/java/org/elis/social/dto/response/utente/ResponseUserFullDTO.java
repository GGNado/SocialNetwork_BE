package org.elis.social.dto.response.utente;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.elis.social.dto.response.chat.ResponseChatDTO;
import org.elis.social.dto.response.post.ResponsePostDTO;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ResponseUserFullDTO {
    private ResponseUserDTO user;
    private List<ResponsePostDTO> postList;
}
