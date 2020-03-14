// Left Pressed é chamado quando o MOUSE ESQUERDO é CLICADO

angle = random(360);

dx = cos(degtorad(angle));
dy = -sin(degtorad(angle));

spd++;

image_angle = angle;

pontos++;

// show_message(pontos); Abre um Pop Up com o valor dos pontos 
// show_debug_message(pontos) // Mostra no console o valor dos pontos