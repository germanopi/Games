// Não mostra a layer isometrica
layer_set_visible("Isometric_map",false);
// Cria uma matriz do tamanho da layer isometrica
global.mapaFinal = ds_grid_create(WIDTH_MAP,HEIGHT_MAP);
// Guarda as informações da layer isometrica
var infoMap = layer_tilemap_get_id("Isometric_map");

for(var xx = 0; xx < WIDTH_MAP; xx++){
	for(var yy = 0; yy < HEIGHT_MAP; yy++){
		var tileMapData = tilemap_get(infoMap,xx,yy); // Guarda os dados de cada posição da layer isometrica 
		var tileAtual = [-1,0]; 
		tileAtual[TILE.SPRITE] = tileMapData;
		tileAtual[TILE.Z] = 0;
		global.mapaFinal[# xx,yy] = tileAtual; 
	}	
}