extends KinematicBody2D

# Variaveis
var speed = 250

func _physics_process(delta): 
	# Detecta movimento do jogador
	var velocity = Vector2()
	var moved=false
	
	if Input.is_action_pressed('ui_right'):
		velocity.x += 1 
		moved=true
		get_node("AnimatedSprite").flip_h=false; # Gira a sprite para direita
		print("Indo para direita")
	elif Input.is_action_pressed('ui_left'):
		velocity.x -= 1
		moved=true
		get_node("AnimatedSprite").flip_h=true; # Gira a sprite para esquerda
		print("Indo para esquerda")
	elif Input.is_action_pressed('ui_down'):
		velocity.y += 1
		moved=true
		print("Indo para baixo")
	elif Input.is_action_pressed('ui_up'):
		velocity.y -= 1
		moved=true
		print("Indo para cima")
		
	velocity = velocity.normalized() * speed
	
	move_and_collide(velocity * delta);
	
	# Aplica a animação ao movimento
	if (moved):
		get_node("AnimatedSprite").play("Andando")
	else:
		get_node("AnimatedSprite").stop()
	
	
