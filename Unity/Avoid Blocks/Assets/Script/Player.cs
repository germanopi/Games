using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Player : MonoBehaviour
{
    private float speed = 0.05f;
    private GameObject camera;
    private GameObject gameOverUI;
    public bool gameOver;
    public GameObject pontosUI;
    public double pontos=0.0;
    private bool canJump=false;
    public Rigidbody rigidbody;
    private int jumpForce=250;
    // Start is called before the first frame update
    void Start()
    {
        pontos=0.0;
        gameOver=false;
        camera = GameObject.Find("Main Camera");
        gameOverUI=GameObject.Find("Canvas");
        pontosUI=GameObject.Find("Canvas2").transform.Find("Text").gameObject;
    }

    // Update is called once per frame
    void Update()
    {
        if(gameOver==false){
        camera.transform.position=transform.position - new Vector3(0,-1f,3f); // Camera segue o player
        transform.position+=transform.forward*speed;                          // Move o player na direção da rotação
        if(Input.GetKey("d")){                                                // Movimentação
            //transform.position+= new Vector3(speed,0,0);
        }else if(Input.GetKey("a")){
           // transform.position+= new Vector3(-speed,0,0);
        } if(Input.GetKey(KeyCode.RightArrow)){                                //Rotação
            transform.Rotate(0,2f,0);
            //camera.transform.Rotate(0,2f,0);
        } if(Input.GetKey(KeyCode.LeftArrow)){
            transform.Rotate(0,-2f,0);
            //camera.transform.Rotate(0,-2f,0);
        }if(Input.GetKey(KeyCode.Space)){                                     // Pulo
            if(canJump==true){
                canJump=false;
                rigidbody.AddForce(0,jumpForce,0);
            }
        }

    }else{
        if(Input.GetKey("space")){
            Application.LoadLevel(Application.loadedLevel); // Recomeça jogo
        }
    }
}
    void OnCollisionEnter(Collision collision){ 
        if(collision.gameObject.tag == "Enemy"){
            gameOverUI.GetComponent<Canvas>().enabled=true; // Ativa o canvas 
            gameOverUI.gameObject.active=true; 
            gameOver=true;
        }else if(collision.gameObject.tag=="Floor"){
            canJump=true;
        }
    }
}
