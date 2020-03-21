using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GenerateWord : MonoBehaviour
{
    private float nextY=0f;
    public GameObject plataforma;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        Transform playerPosition=GameObject.Find("player").transform;
        if(playerPosition.position.y>=nextY){
            for(int i =0;i<11;i++){
                float xx=Random.Range(-2f,4f);
                float yy=(nextY+(i*3));
                Instantiate(plataforma,new Vector3(xx,yy,0),Quaternion.identity);
            }
            nextY+=30f;
        }
    }
}
