package com.teste.MagicFridgeAI.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ReceitaIAService {
    private final ChatClient chatClient;
    public ReceitaIAService(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }
    public String criarReceita(String ingredientes){
        String instrucao = """
                Você é um chef de Cozinha Especialista.
                Faça uma string com tags <h2> quando houver título e <p> quando 
                houver parágrafos e fique bem organizado.
                Siga esse formato:
                1. Nome da receita
                2. Ingredientes Solicitados
                3. Tempo de Preparo
                4. Ingradientes Adicionais Necessários
                5. Passo a Passo
                """;
        return chatClient.prompt().system(instrucao)
                .user("Crie uma receita com " + ingredientes)
                .call()
                .content();
    }
}
