using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Movimento : MonoBehaviour
{
    private float dir=0;
    private float speed=0.5f;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        Rigidbody rigidBody=GetComponent<Rigidbody>();
        if(Input.GetKey("up")){
            dir=0;
            if(rigidBody.velocity.magnitude<9f){
                rigidBody.AddForce(Vector3.forward*speed,ForceMode.Impulse);
            }
        }
        if(Input.GetKey("right")){
            dir=90;
            if(rigidBody.velocity.magnitude<9f){
                rigidBody.AddForce(Vector3.right*speed,ForceMode.Impulse);
            }
        } 
        if(Input.GetKey("left")){
            dir=-90;
            if(rigidBody.velocity.magnitude<9f){
                rigidBody.AddForce(Vector3.left*speed,ForceMode.Impulse);
            }
        }
        if(Input.GetKey("down")){
            dir=0;
            if(rigidBody.velocity.magnitude<9f){
                rigidBody.AddForce(-Vector3.forward*speed,ForceMode.Impulse);
            }
        }
        transform.rotation=Quaternion.Lerp(transform.rotation,Quaternion.Euler(0,dir,0),Time.deltaTime*2f);
    }
}
