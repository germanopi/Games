// Região de propagação
part_emitter_region(part_system,part_emitter,0,50,0,50,global.p1,ps_distr_gaussian);
// Ativa 2 particulas
part_emitter_burst(part_system,part_emitter,global.p1,2);

alarm[0]=60;