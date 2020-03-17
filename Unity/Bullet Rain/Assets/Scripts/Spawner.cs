using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Spawner : MonoBehaviour
{
    public GameObject bullet;
    float timer;
    float currentTime;
    // Start is called before the first frame update
    void Start()
    {
        currentTime=0;
        timer=Random.Range(1f,3f);
        GameObject player=GameObject.Find("Player");
        transform.LookAt(player.transform);    
    }

    // Update is called once per frame
    void Update()
    {
        currentTime+=Time.deltaTime;
        if(currentTime>=timer){             // Hora de atirar
            if(Random.Range(0,100f)>50f){   // Chance de atirar
            GameObject obj=Instantiate(bullet,transform.position+transform.forward*2f,Quaternion.identity);
            Destroy(obj,4f);   // Destroi a bullet
            }
            currentTime=0;
        }    
        
    }
}
