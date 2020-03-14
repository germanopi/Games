var layerId= layer_tilemap_get_id("Tiles_2"); // Pega indice dos sprites no Tiles_2
var solid= tilemap_get(layerId,0,0);  // Pega indice do sprite em (0,0)

if(solid==0){
	// Não existe sprite em (0,0) da layer
}
if (solid>0){
	// Indice da spritesheet do sprite em (0,0)
}
if (solid==-1){
	// Não existe layer
}