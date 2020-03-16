using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MovimentoPlayer : MonoBehaviour
{
    bool jump=false;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        Rigidbody2D rigidbody=GetComponent<Rigidbody2D>();
        if(Input.GetKey("right")){
            rigidbody.AddForce(new Vector2(0.3f,0),ForceMode2D.Impulse);
        }else if(Input.GetKey("left")){
             rigidbody.AddForce(new Vector2(-0.3f,0),ForceMode2D.Impulse);
        }else if(Input.GetKey("up")){
            if(jump){
                jump=false;
                rigidbody.AddForce(new Vector2(0,10f),ForceMode2D.Impulse);
            }
        }
    }

    void OnCollisionEnter2D(Collision2D collider){
        jump=true;
    }
}
