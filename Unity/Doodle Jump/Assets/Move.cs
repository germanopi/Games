using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
public class Move : MonoBehaviour
{
    public float minX=-7,maxX=7f;
    public int pontos=0;
     public Text pontosCanvas;
     
    [SerializeField] // Permite alterar no unity usando mousee
    public float speed=0.09f;

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        float horizontal=Input.GetAxis("Horizontal");
        Vector3 direction=new Vector3(horizontal*speed,0,0);
        transform.position+=direction;
        //transform.position=new Vector3(Mathf.Clamp(transform.position.x,minX,maxX),transform.position.y,transform.position.z);
        SpriteRenderer spriterenderer = GetComponent<SpriteRenderer>(); 
        if(horizontal!=0){
            spriterenderer.flipX=horizontal<0 ? true : false ; // if( horizontal <0 ) { true } else { false }
        }
        
    }

    void OnCollisionEnter2D(Collision2D col){
        Rigidbody2D rigidbody=GetComponent<Rigidbody2D>();
        if(rigidbody.velocity.magnitude<2f){
            GameObject obj=col.gameObject;
            if(obj.GetComponent<checkCollider>().tocado == false){
                obj.GetComponent<checkCollider>().tocado=true;
                pontos++;
                pontosCanvas.text="Pontos: "+ pontos;
            }
            rigidbody.AddForce(new Vector2(0,8f),ForceMode2D.Impulse);  
        }
        
    }
}
