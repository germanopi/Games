using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Craft : MonoBehaviour
{
    public Animator animator;
    public GameObject grass;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        if(Input.GetMouseButtonDown(0)){
            animator.Play("craft",-1,0);
            RaycastHit hit;
            LayerMask mask =LayerMask.GetMask("Water");
            if(Physics.Raycast(transform.position,transform.forward,out hit,10.0f)){
                GameObject obj=hit.collider.gameObject;
                GameObject novoCubo=Instantiate(grass,new Vector3(obj.transform.position.x,obj.transform.position.y+1.0f,obj.transform.position.z),Quaternion.identity);
                novoCubo.transform.parent=obj.transform.parent;
            }
        }
        if(Input.GetKeyUp(KeyCode.Return)){
            GameObject[] obj=GameObject.FindGameObjectsWithTag("vida");
        
        }
    }
}
