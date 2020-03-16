using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MovimentoCamera1 : MonoBehaviour
{
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        if(Input.GetKeyDown("w")){
            transform.Translate(0,0,1f);
        }
        if(Input.GetKeyDown("a")){
            transform.Translate(-1f,0,0);
        }
        if(Input.GetKeyDown("d")){
            transform.Translate(1f,0,0);
        }
        if(Input.GetKeyDown("s")){
            transform.Translate(0,0,-1f);
        }
    }
}
