using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class ball_Movimento : MonoBehaviour
{
    public float dx=0;
    public float dy=-0.05f;
    public float speed=2f;
    private float angle = 0;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
          transform.position = new Vector3(transform.position.x + (dx*speed),transform.position.y + (dy*speed),1); // Move a bola
        if (transform.position.y < GameObject.FindGameObjectWithTag("Player").transform.position.y){ // Game Over
            Application.LoadLevel(Application.loadedLevel);
         }

       GameObject[] bricks = GameObject.FindGameObjectsWithTag("Brick");
        if (bricks.Length == 0){ // Ganhou o jogo
            alternarLevel();
        }
    }

    void alternarLevel(){ // Troca de level 
        int nextSceneIndex = SceneManager.GetActiveScene().buildIndex+1;
        if(nextSceneIndex<SceneManager.sceneCountInBuildSettings){
            SceneManager.LoadScene(nextSceneIndex);
        }else{
            SceneManager.LoadScene(0);
        }
    }

    // Colisão com player e paredes
    void OnCollisionEnter2D(Collision2D collider){
        if (collider.gameObject.tag == "Player"){
            float angle = 0;
            if (Random.Range(0,100f) < 50f){
                angle = Random.Range(20f, 45f);
            }else{
                angle = Random.Range(180f+20f, 180f+45f);
            }
        
            dx = Mathf.Cos(Mathf.Deg2Rad * angle);
            dy = Mathf.Sin(Mathf.Deg2Rad * angle);
            if (dy < 0){
                dy *= -1;
            }
            speed = 0.2f;
        }else if(collider.gameObject.tag=="WallRight" || collider.gameObject.tag=="WallLeft"){
            dx*=-1;
        }else if(collider.gameObject.tag=="Brick"){
            dy*=-1;
            Destroy(collider.gameObject);
        }else if(collider.gameObject.tag=="BrickPermanente"){
            dy*=-1; 
        }
    }
}
