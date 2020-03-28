using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class AI : MonoBehaviour
{
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        if(Vector3.Distance(transform.position,GameObject.Find("FPSController").transform.position)<16f);
        transform.LookAt(GameObject.Find("FPSController").transform);
        transform.eulerAngles=new Vector3(0,transform.eulerAngles.y,0);
        transform.position+=transform.forward * 0.04f;
    }
}
