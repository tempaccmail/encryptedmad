
import 'package:flutter/material.dart';

class Home extends StatelessWidget {
  const Home({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Center(child: Text("Exercise 1")),
      ),
      body: Center(
          child: Column(
            children: [
              Text(
                "Hello World!",
                style: TextStyle(fontSize: 30, fontWeight: FontWeight.bold, color: Colors.deepOrange),
      ),
          Text(
            "Hello World!",
            style: TextStyle(fontSize: 40, fontWeight: FontWeight.bold, color: Colors.deepPurple),
          ),
            ],
          )),
    );
  }
}
