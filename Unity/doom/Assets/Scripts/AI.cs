using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class AI : MonoBehaviour
{
    public int life = 5;
    public float spd = 0.003f;
    public Animator anim;
    // Start is called before the first frame update
    void Start()
    {
        anim.Play("anim_inimigo_running");  
        spd = 0.03f;
    }

    // Update is called once per frame
    void Update()
    {
        // Segue o player
        transform.eulerAngles = new Vector3(0,GameObject.Find("Main Camera").transform.eulerAngles.y,0);
        transform.position -= transform.forward * this.spd;
    }

    void OnCollisionStay(Collision collision){
        if (collision.gameObject.tag == "MainCamera"){ // Dá dano ao tocar no player
            float chanceDano = Random.Range(0, 100);
            if (chanceDano < 50){
                playerMove.vidaAtual--;
            }
        }
    }
}
