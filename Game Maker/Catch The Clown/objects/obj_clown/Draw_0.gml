// Sobreescreve o que vai ser renderizado no jogo

draw_self(); // Comunica ao gamemaker para renderizar normalmente os objetos padrões

// Adicionalmete

draw_set_font(fnt_ui); // Escolhe a fonte
draw_text(20,20,"Pontos:"+string(pontos)); // Renderiza o texto em pontos na posição (20,20)
draw_text(room_width-110,20,"Tempo:"+string(tempo)); // Renderiza o texto em tempo na posição (tamanho horizontal da tela menos 110,20)