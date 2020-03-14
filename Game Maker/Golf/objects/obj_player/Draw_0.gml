draw_self();

var xx=10;
var yy=10;
var width=xx+100;
var height=yy+20;

// Renderiza a barra de força
draw_set_color(c_white);
draw_rectangle(xx,yy,width,height,1); // 1 = Não preenchido

var resultado=(velocidade/maxVelocidade)*100;

if(resultado>0){
draw_set_color(c_blue);
draw_rectangle(xx,yy,xx+resultado,height,0); // 0 = Preenchido
}

// Renderiza as tacadas e pontos
draw_set_color(c_white);
draw_set_font(fnt_golf);
draw_text(200,10,"Tacadas: "+string(tacadas));
draw_text(350,10,"Pontos: "+string(pontos));