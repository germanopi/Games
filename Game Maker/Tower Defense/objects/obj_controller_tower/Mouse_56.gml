if(towerHolder!=-1 && canPlace){ // Posiciona a torre escolhida do inventario
	var xx=floor(mouse_x/32)*32;
	var yy= floor(mouse_y/32)*32;
	var obj= instance_create_depth(xx,yy,-1,towerHolder);
	obj.isInventory=false; 
	towerHolder=-1; 
	canPlace=false;
	alarm[0]=choose(120,180); // Delay para colocar outra torre
}