using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Bullet : MonoBehaviour
{
    float speed;
    // Start is called before the first frame update
    void Start()
    {
        speed=0.2f;
       GameObject player=GameObject.Find("Player");
        transform.LookAt(player.transform);    
    }

    // Update is called once per frame
    void Update()
    {
        transform.position+=transform.forward*speed;    // Segue na direção da camera
    }
}
