using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class player_Movimento : MonoBehaviour
{
    public Rigidbody2D rigidbody;
    public float speed =5f;
    // Start is called before the first frame update
    void Start()
    {
        rigidbody= gameObject.GetComponent<Rigidbody2D>(); // Referencia o componente RigidBody
    }

    // Update is called once per frame
    void Update()
    {
        if(Input.GetKey("right")){ // Move para direita
            //rigidbody.AddForce(new Vector3(speed,0,0));
            rigidbody.velocity = new Vector3(5f,0,0);
        }else if(Input.GetKey("left")){ // Move para esquerda 
           // rigidbody.AddForce(new Vector3(-speed,0,0)); 
             rigidbody.velocity = new Vector3(-5f,0,0);
        }
        if(Input.GetKeyUp("right") || Input.GetKeyUp("left")){
             rigidbody.velocity = new Vector3(0,0,0);
        }
    }
}
