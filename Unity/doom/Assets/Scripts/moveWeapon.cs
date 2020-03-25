using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class moveWeapon : MonoBehaviour
{

    public AudioSource audio;

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {

        if (Input.GetMouseButtonDown(0)) {  // Toca o audio de tiro
            audio.Play();
            RaycastHit hit;
            if (Physics.Raycast(transform.position, transform.forward, out hit, 10f)){ // Dá dano no inimigo
                if (hit.collider.gameObject.tag == "inimigo"){
                    GameObject inimigo = hit.collider.gameObject;
                    inimigo.GetComponent<AI>().life--;
                    if (inimigo.GetComponent<AI>().life == 0){ // Destroi o inimigo
                        Destroy(hit.collider.gameObject);
                    }
                    
                }
            }
        }
    }
}
