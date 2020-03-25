using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class playerMove : MonoBehaviour
{
    private float yaw = 0.0f;
    private float pitch = 0.0f;

    private float spd = 0.07f;

    private float speedH = 2.0f;
    private float speedV = 2.0f;

    public static float vidaAtual = 200f;


    // Start is called before the first frame update
    void Start()
    {
        // Deixa o cursor travado e invisivel
        Cursor.visible = false;
        Cursor.lockState = CursorLockMode.Locked;
    }

    // Update is called once per frame
    void Update()
    {
        // Movimento do personagem
        if (Input.GetKey("w")){
            transform.position += (transform.forward * spd);
        }
        if (Input.GetKey("s")){
            transform.position += (transform.forward * -spd);
        }
        if (Input.GetKey("d")){
            float dir = transform.eulerAngles.y - 90.0f;
            Vector3 spdTemp = new Vector3(Mathf.Sin(dir *Mathf.Deg2Rad),0,Mathf.Cos(dir*Mathf.Deg2Rad));
            transform.position = transform.position + (spdTemp * -spd);
        }
        if (Input.GetKey("a")){
            float dir = transform.eulerAngles.y + 90.0f;
            Vector3 spdTemp = new Vector3(Mathf.Sin(dir * Mathf.Deg2Rad), 0, Mathf.Cos(dir * Mathf.Deg2Rad));
            transform.position = transform.position + (spdTemp * -spd);
        }
        // Movimento da camera
        yaw += speedH * Input.GetAxis("Mouse X");
        pitch -= speedV * Input.GetAxis("Mouse Y");
        transform.eulerAngles = new Vector3(pitch,yaw,0.0f);

        // Canvas 
        RectTransform image = GameObject.Find("Canvas").transform.Find("vida_ui").GetComponent<RectTransform> ();
        image.sizeDelta = new Vector2(vidaAtual,15f);

        // Reseta o level
        if (vidaAtual <= 0){
            Application.LoadLevel(Application.loadedLevel);
        }
    }

        // Abre a porta
    void OnCollisionEnter(Collision col){
        if (col.gameObject.tag == "door"){
            col.gameObject.GetComponent<moveDoor>().open = true;
        }
    }
}
