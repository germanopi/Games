using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.AI;

public class playerControl : MonoBehaviour
{

    public Camera cam;              
    public NavMeshAgent agent;      
  
    // Update is called once per frame
    void Update(){
        if (Input.GetMouseButtonDown(0)){
            Ray ray = cam.ScreenPointToRay(Input.mousePosition); // Transforma a posição 2d do mouse no local 3d do mundo
            RaycastHit hit;

            if(Physics.Raycast(ray, out hit)) {                   // Local clicado é possivel de ir
                if(hit.collider.gameObject.tag != "wall") {       
                    agent.SetDestination(hit.point); // Move para posição
                    Debug.Log("foi");
                }
            }
        }
    }
}
