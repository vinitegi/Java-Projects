package dio.finalproject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@EnabledIfEnvironmentVariable(named = "GEMINI_API_KEY", matches = ".+")

public class GeminiChatModelIT {

    @Autowired
    ChatModel chatModel;

    @Test
    void should_receiveResponse_when_chatModelIsCalled() {
        String response = chatModel.call(
                "Gere um registro de budgeting com descrição de gasto, valor em reais e local."
        );

        assertThat(response).isNotBlank();

        System.out.println(response);
    }
}