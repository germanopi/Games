
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ColisãoChão : MonoBehaviour
{
    public bool bateu;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        if(bateu)
        {
        Debug.Log("Bateu!");    
        }
    }
}
