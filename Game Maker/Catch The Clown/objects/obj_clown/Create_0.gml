// Create só é chamado UMA VEZ  quando o objeto é criado

angle = random(360); // Gera algum numero entre 0 e 360 

dx = cos(degtorad(angle)); // Calcula a direção horizontal pelo cosseno do angulo
dy = -sin(degtorad(angle)); // Calcula a direção vertical pelo seno do angulo

spd = irandom_range(8,10); // Gera algum numero no range entre 8 e 10 

image_angle = angle; // Troca o angulo do sprite de acordo com o valor da variavel

pontos = 0; // Pontos é inicializado com valor 0

tempo = 0; // Tempo é inicializado com valor 0

alarm[0] = 60; // alarm[0] chama o evento alarm0 a cada 60fps = 1 seg 