using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class checkCollider : MonoBehaviour
{
    public bool tocado=false;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        float player=GameObject.Find("player").transform.position.y;
        if(transform.position.y-player<-30f){
            Destroy(gameObject);
        }
    }
}
