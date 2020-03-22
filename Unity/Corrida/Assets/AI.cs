using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class AI : MonoBehaviour
{
    private float dir=0;
    private float speed=0.5f;
    private bool tocou=false;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        GameObject boxRight=GameObject.FindGameObjectWithTag("right");
        if(Vector3.Distance(transform.position,boxRight.transform.position)<10f){
            dir=90;
        }
         GameObject boxUp=GameObject.FindGameObjectWithTag("up");
        if(Vector3.Distance(transform.position,boxUp.transform.position)<10f){
            dir=0;
        }
         GameObject boxLeft=GameObject.FindGameObjectWithTag("left");
        if(Vector3.Distance(transform.position,boxLeft.transform.position)<10f){
            dir=-90;
        }
        Rigidbody rigidBody=GetComponent<Rigidbody>();
        if(dir==0){
            if(rigidBody.velocity.magnitude<9f){
                rigidBody.AddForce(Vector3.forward*speed,ForceMode.Impulse);
            }
        }
        if(dir==90){
            if(rigidBody.velocity.magnitude<9f){
                rigidBody.AddForce(Vector3.right*speed,ForceMode.Impulse);
            }
        } 
        if(dir==-90){
            if(rigidBody.velocity.magnitude<9f){
                rigidBody.AddForce(Vector3.left*speed,ForceMode.Impulse);
            }
        }
        transform.rotation=Quaternion.Lerp(transform.rotation,Quaternion.Euler(0,dir,0),Time.deltaTime*2f);
    }
}
