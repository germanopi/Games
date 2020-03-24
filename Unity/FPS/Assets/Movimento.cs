using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class Movimento : MonoBehaviour
{

    public float life = 10;


    public AudioSource explosao;
    public Image vidaUI;
    public GameObject bullet;
    // Start is called before the first frame update
    void Start()
    {
        explosao = GetComponent<AudioSource>();
    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetButtonUp("Fire1"))
        {
            
            //Debug.DrawRay(transform.position,transform.forward*10f,Color.red);
            GameObject obj = Instantiate(bullet,transform.position + transform.forward* 5f,Quaternion.identity);
            obj.GetComponent<bulletMove>().forward = transform.forward;
            Destroy(obj,2f);
        }

        Debug.Log(life);
        vidaUI.GetComponent<RectTransform>().sizeDelta = new Vector2((life/10f)*200f,20f);
        if(life<=0 ){
            Application.LoadLevel(Application.loadedLevel);
        }
    }

    public void takeDamage(){
        explosao.Play();
        life--;

    }

   

  
}
