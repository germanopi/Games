var tileData, isometricX, isometricY, tileIndex, tileZ;

for(var xx = 0; xx < WIDTH_MAP; xx++){
	for(var yy = 0; yy < HEIGHT_MAP; yy++){
		tileData = global.mapaFinal[# xx,yy]; 
		isometricX = getPosIsometricX(xx,yy);
		isometricY = getPosIsometricY(xx,yy);
	
		tileIndex = tileData[TILE.SPRITE];
		tileZ = tileData[TILE.Z];
	
		if(tileIndex != 0){
			draw_sprite(spr_isometricTile,tileIndex-1,isometricX,isometricY+tileZ);
		}
	}	
}